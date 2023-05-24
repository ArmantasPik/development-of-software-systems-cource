package foodapp.rest;

import foodapp.entities.Item;
import foodapp.interceptors.LoggedInvocation;
import foodapp.persistence.ItemsDAO;
import foodapp.rest.contracts.ItemDto;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Delete;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/items")
public class ItemsController {

    @Inject
    @Setter @Getter
    private ItemsDAO itemsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @LoggedInvocation
    public Response getById(@PathParam("id") final Long id) {
        Item item = itemsDAO.findOne(id);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ItemDto itemDto = new ItemDto();
        itemDto.setName(item.getName());
        itemDto.setQuantity(item.getQuantity());

        return Response.ok(itemDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Long itemId, ItemDto itemData) {
        try {
            Item existingItem = itemsDAO.findOne(itemId);

            if (existingItem == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            existingItem.setName(itemData.getName());
            existingItem.setQuantity(itemData.getQuantity());
            itemsDAO.update(existingItem);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(ItemDto itemDto) {
        try {
            Item newItem = new Item();

            newItem.setName(itemDto.getName());
            newItem.setQuantity(itemDto.getQuantity());

            itemsDAO.persist(newItem);

            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") final Long itemId) {
        itemsDAO.delete(itemId);

        return Response.ok().build();
    }
}

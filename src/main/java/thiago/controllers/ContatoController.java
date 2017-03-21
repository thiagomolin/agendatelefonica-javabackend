package thiago.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import thiago.data.Contato;
import thiago.data.ContatoDAO;

@Path("contatos")
public class ContatoController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Contato> listContatos() {
        try {
            ContatoDAO contatoDAO = new ContatoDAO();
            return contatoDAO.listar();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Contato getContato(@PathParam("id") long id) {
        try {
            ContatoDAO contatoDAO = new ContatoDAO();
            return contatoDAO.selecionar(id);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Contato contato) {
        try {
            ContatoDAO contatoDAO = new ContatoDAO();
            contatoDAO.inserir(contato);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response edit(Contato contato) {
        try {
            
            ContatoDAO contatoDAO = new ContatoDAO();
            contatoDAO.alterar(contato);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DELETE
    @Path("{id}/")
    public Response delete(@PathParam("id") long id) {
        try {
            ContatoDAO chamadoDAO = new ContatoDAO();
            chamadoDAO.excluir(id);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}

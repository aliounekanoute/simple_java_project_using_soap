package sn.blog;

import javax.xml.ws.Endpoint;

import sn.blog.controllers.BlogAppController;

/**
 * Hello world!
 *
 */
public class BlogApp
{
    public static void main( String[] args )
    {
        BlogAppController controller = new BlogAppController();
        final String host = "localhost";
        final String port = "1234";
        final String url = String.format("http://%s:%s/", host, port);

        Endpoint.publish(url, controller);
        System.out.println( "Le serveur a demarre");
    }
}

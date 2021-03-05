package sn.diallo;

import sn.diallo.controller.LocataireController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Initialisation application");
        LocataireController locataireController = new LocataireController();
        locataireController.process();
    }
}

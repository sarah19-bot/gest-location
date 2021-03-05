package sn.diallo.controller;

import sn.diallo.repository.AppartementRepository;
import sn.diallo.repository.LocataireRepository;
import sn.diallo.repository.ProprietaireRepository;
import sn.diallo.repository.jdbc.DataSource;
import sn.diallo.repository.jdbc.JdbcProprietaireRepository;
import sn.diallo.repository.jdbc.MysqlDataSource;
import sn.diallo.repository.ram.ArrayBasedAppartementRepository;
import sn.diallo.repository.ram.ArrayBasedLocataireRepository;
import sn.diallo.service.console.*;
import sn.diallo.service.DisplayService;
import sn.diallo.service.MenuService;

public class LocataireController {
    private final DisplayService displayService ;
    private final MenuService scannerMenuService ;

    public LocataireController(){
        AppartementRepository appartementRepository = new ArrayBasedAppartementRepository();
        DataSource dataSource = new MysqlDataSource();
        displayService = new ConsoleDisplayService(appartementRepository);
        ProprietaireRepository proprietaireRepository = new JdbcProprietaireRepository(dataSource);
        LocataireRepository locataireRepository = new ArrayBasedLocataireRepository();
        scannerMenuService = new ScannerMenuService(displayService, appartementRepository, locataireRepository, proprietaireRepository);
    }

    public void process(){

        displayService.afficherBienvenu();
        displayService.afficherMenuPrincipal();
        scannerMenuService.afficherMenu();
    }
}

package com.niedz.ankiety.controller;

import com.niedz.ankiety.service.SerwisAnkiet;
import com.niedz.ankiety.service.SerwisOdpowiedzi;
import com.niedz.ankiety.service.SerwisPytan;
import com.niedz.ankiety.service.SerwisUzytkownika;
import org.springframework.beans.factory.annotation.Autowired;

public class ankiety {
    @Autowired
    private SerwisAnkiet serwisAnkiet;

    @Autowired
    private SerwisOdpowiedzi serwisOdpowiedzi;

    @Autowired
    private SerwisPytan serwisPytan;

    @Autowired
    private SerwisUzytkownika serwisUzytkownika;


}

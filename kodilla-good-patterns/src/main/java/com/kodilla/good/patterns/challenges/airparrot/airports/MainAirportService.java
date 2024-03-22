package com.kodilla.good.patterns.challenges.airparrot.airports;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainAirportService {

    private List<Airport> allAirports = new ArrayList<>();
    private final Airport gdanskAirport = new GdanskAirport("Port Lotniczy im. Lecha Wałęsy", "GDN");
    private final Airport katowiceAirport = new KatowiceAirport("Katowice Airport", "KTW");
    private final Airport krakowAirport = new KrakowAirport("Port Lotniczy im. Jana Pawła II", "KRK");
    private final Airport poznanAirport = new PoznanAirport("Port Lotniczy im. Henryka Wieniawskiego", "POZ");
    private final Airport rzeszowAirport = new RzeszowAirport("Port Lotniczy Jasionka", "RZE");
    private final Airport szczecinAirport = new SzczecinAirport("Port Lotniczy im. NSZZ \"Solidarność\"", "SZZ");
    private final Airport warszawaAirport = new WarszawaAirport("Lotnisko Chopina", "WAW");
    private final Airport wroclawAirport = new WroclawAirport("Port Lotniczy im. Mikołaja Kopernika", "WRO");

    public MainAirportService() {
        allAirports.addAll(initAllAirports());
        addDepAndArrivalAirports();
    }

    private Collection<? extends Airport> initAllAirports() {
        List<Airport> initatedAirports = new ArrayList<>();
        initatedAirports.addAll(Arrays.asList(gdanskAirport, katowiceAirport, krakowAirport, poznanAirport,
                rzeszowAirport, szczecinAirport, warszawaAirport, wroclawAirport));

        return initatedAirports;
    }

    private void addDepAndArrivalAirports() {
        warszawaAirport.addSeveralAirports(Arrays.asList(gdanskAirport, katowiceAirport, krakowAirport,
                poznanAirport, rzeszowAirport, wroclawAirport));
        gdanskAirport.addSeveralAirports(Arrays.asList(katowiceAirport, krakowAirport, poznanAirport,
                rzeszowAirport, warszawaAirport, wroclawAirport));
        katowiceAirport.addSeveralAirports(Arrays.asList(gdanskAirport, poznanAirport, warszawaAirport, wroclawAirport));
        krakowAirport.addSeveralAirports(Arrays.asList(gdanskAirport, poznanAirport, warszawaAirport));
        poznanAirport.addSeveralAirports(Arrays.asList(gdanskAirport, katowiceAirport, krakowAirport, warszawaAirport, szczecinAirport));
        rzeszowAirport.addSeveralAirports(Arrays.asList(gdanskAirport, warszawaAirport));
        szczecinAirport.addSeveralAirports(Arrays.asList(poznanAirport, warszawaAirport));
        wroclawAirport.addSeveralAirports(Arrays.asList(gdanskAirport, katowiceAirport, warszawaAirport));
    }

    public List<Airport> getAllAirports() {
        return allAirports;
    }
}

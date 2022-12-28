package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.Internet.InternetEtisalat;
import com.example.SoftwareApiProject.Models.Internet.InternetOrange;
import com.example.SoftwareApiProject.Models.Internet.InternetVodafone;
import com.example.SoftwareApiProject.Models.Internet.InternetWE;
import com.example.SoftwareApiProject.Models.Services;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@Service
//@AllArgsConstructor
public class servicesProvidersRepository {
    public static ArrayList<Services> serviceProviders = new ArrayList<Services>();

    InternetEtisalat internetEtisalat;
    InternetOrange internetOrange;
    InternetVodafone internetVodafone;
    InternetWE internetWE;
    public dummy d;


    public servicesProvidersRepository(dummy d, InternetEtisalat internetEtisalat, InternetOrange internetOrange, InternetVodafone internetVodafone, InternetWE internetWE) {
        this.internetEtisalat = internetEtisalat;
        this.internetOrange = internetOrange;
        this.internetVodafone = internetVodafone;
        this.internetWE = internetWE;

        this.d = d;
    }
}

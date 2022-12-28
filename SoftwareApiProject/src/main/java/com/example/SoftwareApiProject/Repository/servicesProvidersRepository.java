package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.Internet.InternetEtisalat;
import com.example.SoftwareApiProject.Models.Internet.InternetOrange;
import com.example.SoftwareApiProject.Models.Internet.InternetVodafone;
import com.example.SoftwareApiProject.Models.Internet.InternetWE;
import com.example.SoftwareApiProject.Models.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class servicesProvidersRepository {
    public static ArrayList<Service> serviceProviders = new ArrayList<Service>();

    public dummy d;
    InternetEtisalat internetEtisalat;
    InternetOrange internetOrange;
    InternetVodafone internetVodafone;
    InternetWE internetWE;



}

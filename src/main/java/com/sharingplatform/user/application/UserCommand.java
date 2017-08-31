package com.sharingplatform.user.application;

import com.sharingplatform.framework.domain.ServiceCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AMC on 2017/8/29.
 */
public class UserCommand extends ServiceCommand {

    public static Map<String, String> plants = new HashMap<String, String>();

    static {
        plants.put("669","DFS");
        plants.put("599","Daimler Trucks and Buses (China) Ltd");
        plants.put("986","MBC");
        plants.put("786","MBC");
        plants.put("683","Vans");
        plants.put("688","MBC");
        plants.put("968","MBC");
        plants.put("133","MBC");
        plants.put("520","DFS");
        plants.put("685","DFS");
        plants.put("104","MBC");
        plants.put("598","Daimler Trucks");
        plants.put("369","MBC");
    }

}

package com.jasonbutwell.recyclerviewexample;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by J on 23/02/2017.
 */

public class FakeDataHelper {

    public static ArrayList<String> generateFakeData() {

        ArrayList<String> names = new ArrayList<>();

        String exampleNameData[] = {
                "Fred Blogs",
                "John Doe",
                "Carmen Silvera",
                "Jack Murphy",
                "Brian Kacks",
                "Stuart Maloney",
                "Hose Barrera",
                "John Connor",
                "Arthur Bottom",
                "Mike Munt"
        };

        // Create some fake data as an array of Strings

        Collections.addAll(names, exampleNameData);

        // Return that array
        return names;
    }

}

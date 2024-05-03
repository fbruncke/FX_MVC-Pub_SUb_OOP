package com.example.fx_simplenavminusdatabinding;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class MessageBroker {

    private static MessageBroker instance = null;

    enum Subjects
    {
        info,
        day
    }

    private MessageBroker()
    {}

    public static MessageBroker getInstance()
    {
        return instance!=null?instance:(instance = new MessageBroker());
    }

    private List<Pair<Subjects, Subscriber>> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subsc, Subjects subject){
        //test if list already contains key/value
        subscribers.add(new Pair<>(subject, subsc));
    }

    public void unsubscribe(){
        //TODO
    }

    public void publish(Subjects subject, String message){

        for(Pair<Subjects, Subscriber> pair : subscribers )
        {
            if( subject == pair.getKey() )
            {
                pair.getValue().update(message);
            }
        }
    }

}

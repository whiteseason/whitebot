package com.whiteseason.whitebot.client;


import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class Test {
    private Test(){
        super();
    }
    public static void main(String[] args) throws Exception {
        Class testc = Test.class;
        Constructor testco = testc.getDeclaredConstructor();
        int modifiers = testco.getModifiers();
        boolean isprivate = Modifier.isPrivate(modifiers);
        String string = Modifier.toString(modifiers);
        System.out.println("isprivate:"+isprivate+"name:"+string);
    }

}

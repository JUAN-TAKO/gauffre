package Controller;

import Model.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AIPlayer {

    public void GenerateConfigs(Grid config, Object obj, Method method) {
        for (int j = 0; j < config.height(); j++) {
            for (int i = 0; i < config.width(); i++) {
                if (config.get(i, j)) {
                    Grid new_config = config.copy();
                    new_config.play(i, j);
                    try {
                        method.invoke(obj, new_config);
                    } catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }    
        }
    }

}
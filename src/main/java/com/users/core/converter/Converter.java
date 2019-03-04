package com.users.core.converter;

import com.users.core.entity.User;
import com.users.core.model.MUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("converter")
public class Converter {

    /*    public MUser convertToMUser(User user){

            MUser mUser = new MUser();

            mUser.setId(user.getId());
            mUser.setName(user.getName());
            mUser.setLastname(user.getLastname());
            mUser.setEmail(user.getEmail());
            mUser.setMovilephone(user.getMovilephone());

            return mUser;

        }*/
    public List<MUser> converterList(List<User> users) {
        List<MUser> musers = new ArrayList<>();

        //entiendo que recorre todos los usuarios y añade esos usuaros al array musers
        for (User user : users) {
            //new MUser hace referencia al constructor MUser que copia los datas de User,
            // con la finalidad de convertir un User a MUser
            //el constructor MUser(User user) copia los datos de user y se lo asigna a las
            // propiedades de MUser
            musers.add(new MUser(user));
//            musers.add(convertToMUser(user) );
        }

        /*for(User user: users){
            MUser mUser = new MUser(user);
            musers.add(mUser);
        }*/

        return musers;
    }
}

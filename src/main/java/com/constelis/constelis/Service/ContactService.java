package com.constelis.constelis.Service;

import com.constelis.constelis.Dao.ContactDao;
import com.constelis.constelis.Model.Client;
import com.constelis.constelis.Model.Contact;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactDao contactDao;

    public ContactService(@Qualifier("ContactDao") ContactDao contactDao ){
        this.contactDao=contactDao;
    }
    public List<Contact> findAll(){
        return contactDao.findAll();
    }

    public Contact addContact(Contact contact){
        return contactDao.addContact(contact);
    }

    public List<Contact> findByName(String firstName,String lastName){
        return contactDao.findByName(firstName,lastName);
    }

    public UpdateResult updateContact(String id , Contact contact){
        return contactDao.updateContact(id,contact);
    }

    public Contact deleteById(String id){
        return contactDao.deleteById(id);
    }

    public Contact findById(String id){
        return contactDao.findById(id);
    }


}

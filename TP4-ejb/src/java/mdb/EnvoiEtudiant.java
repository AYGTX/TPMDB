/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import java.io.Console;
import java.io.Serializable;
import java.util.logging.Level;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import mods.Etudiant;

/**
 *
 * @author AYGTX
 */
@Stateless
public class EnvoiEtudiant implements EnvoiEtudiantLocal {

    @Resource(mappedName = "jms/Q1")
    private Queue Q1;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    @Override
    public void Envoi(Etudiant e) {
        
        sendJMSMessageToQ1(e);
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /*private void sendJMSMessageToQ1(String messageData) {
        context.createProducer().send(Q1, messageData);
    }*/
    
    private void sendJMSMessageToQ1(Etudiant messageData) {
        context.createProducer().send(Q1, (Serializable) messageData);
    }
    
}

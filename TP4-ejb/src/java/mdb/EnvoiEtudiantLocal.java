/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import javax.ejb.Local;
import mods.Etudiant;

/**
 *
 * @author AYGTX
 */
@Local
public interface EnvoiEtudiantLocal {

    void Envoi(Etudiant parameter);
    
}

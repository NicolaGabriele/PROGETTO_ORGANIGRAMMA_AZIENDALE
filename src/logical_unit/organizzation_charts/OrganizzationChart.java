package logical_unit.organizzation_charts;

import logical_unit.users.User;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.Collection;

public interface OrganizzationChart extends Serializable {



    /**
     *
     * @param organizzationChart l'OrganizzationChart da aggiungere
     * @return vero se l'aggiunta è andata a buon fine, falso altrimenti
     */
    boolean add(OrganizzationChart organizzationChart);



    /**
     *
     * @param organizzationChart OrganizzationChart da rimuovere
     * @return vero se la rimozione è andata a buon fine, falso altrimenti
     */
    boolean remove(OrganizzationChart organizzationChart);


    /**
     *
     * @param organizzationChart OrganizzationChart da cercare
     * @return vero se organizzationChart è contenuto come figlio, false altrimenti
     */
    boolean contain(OrganizzationChart organizzationChart);


    /**
     *
     * @param role ruolo per cui verificare la compatibilità
     * @return vero se il ruolo è compatibile con l'organo, falso altrimenti
     */
    boolean isSupported(Role role);


    /**
     *
     * @param role: ruolo da aggiungere
     */
    void addRole(Role role);



    /**
     *
     * @param role ruolo da rimuovere
     */
    void removeRole(Role role);



    /**
     *
     * @param member membro da aggiungere
     */
    void addMember(User member,Role role);



    /**
     *
     * @param member membro da rimuovere
     */
    void removeMember(User member);



    /**
     *
     * @param member membro da cercare
     * @return
     */
    boolean isMember(User member);


    /**
     *
     * @return ritorna i figli
     */
    Collection<OrganizzationChart> getChildren();



    /**
     *
     * @return collezione di dipendenti dell'organizzazione
     */
    Collection<User> getEmployees();


    /**
     *
     * @return ruoli supportati
     */
    Collection<Role> getSupportedRoles();

    /**
     * @return il nome dell'organizzazione
     */
    String getName();
}//OrganizzationChart

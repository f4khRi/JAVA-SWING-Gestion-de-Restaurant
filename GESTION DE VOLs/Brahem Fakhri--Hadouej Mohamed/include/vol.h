#ifndef VOL_H
#define VOL_H
#include"destination.h"
#include"prix.h"
#include"date.h"
#include"voyageur.h"
#include<windows.h>
#include<fstream>
class vol
{


    unsigned nb_p,nb_res;
    std::string n_vol;
    date m_date;
    prix m_prix;
    destination m_destination;
    std::vector<voyageur> passager;

    public :
    vol();
    vol(std::string num);
    bool recherche(const std::vector<vol> &vols);
    void ajout_vol(std::string num,unsigned nb);
    bool recherche(const std::vector<vol> &vols,int &pos);
    bool recherche_pass(std::string nn,int &pos);
    void confirmer(int pos);
    void annuller_reservation(int pos);
    void reserver();
    void modifier_date();
    void modifier_heur();
    void afficher();
    void afficher_pass();
    bool controle_date(int a,int m,int j,int h,int mn);
    void ecrire_fichier(std::fstream &fichier);
    void lire_fichier(std::fstream &fichier);
};

#endif // VOL_H

#ifndef VOYAGEUR_H
#define VOYAGEUR_H


class voyageur
{
    private :
    std::string npassport;
    bool confirme;
    int age;
    std::string nom;
    std::string prenom;
    std::string titre;

    public :

    voyageur();
    voyageur(std::string n,std::string p,std::string t, int     age,std::string npass);
    void confirmation();
    void reservation();
    void affiche();
    std::string get_npass();
    void ecrire_fichier(std::fstream &fichier);
    void lire_fichier(std::fstream &fichier);
};
#endif // VOYAGEUR_H

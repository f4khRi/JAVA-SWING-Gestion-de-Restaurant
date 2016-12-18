#ifndef DESTINATION_H
#define DESTINATION_H


class destination
{
    std::string depart,arrivee;

    public :
    destination();
    destination(std::string dep,std::string arv);
    std::string get_depart();
    std::string get_arrivee();
    void dest();
    void afficher();
    void lire_fichier(std::fstream &fichier);
};

#endif // DESTINATION_H

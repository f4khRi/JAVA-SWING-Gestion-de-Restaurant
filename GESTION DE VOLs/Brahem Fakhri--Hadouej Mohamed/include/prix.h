#ifndef PRIX_H
#define PRIX_H


class prix
{
    public :
    prix();
    prix(float p);
    void prixv();
    void afficher();
    float get_prix();
    void lire_fichier(std::fstream &fichier);
    private :
    float pr;
};

#endif // PRIX_H

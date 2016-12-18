#include<iostream>
#include<fstream>
#include"prix.h"
using namespace std;
prix::prix()
{
}
prix::prix(float p)
{
    pr=p;
}

void prix::prixv()
{
    cout<<"entrez le prix de vol :";
    cin>>pr;
}
void prix::afficher()
{
    cout<<pr<<endl;
}
float prix::get_prix()
{
    return pr;
}
void prix::lire_fichier(fstream &fichier)
{
   fichier>>pr;
}

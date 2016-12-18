#include<iostream>
#include<fstream>
#include<string>
#include "voyageur.h"
using namespace std;
    voyageur::voyageur()
    {
    }
voyageur::voyageur(string n,string p,string t, int ag,string npass)
       {
        nom=n;
        prenom=p;
        titre=t;
        age=ag;
        npassport=npass;
        }
void voyageur::reservation()
     {
      string rep;

       cout<<"entrez votre nom    : ";
       cin>>nom;
       cout<<"entrez votre prenom : ";
       cin>>prenom;
       cout<<"entrez votre age    : ";
       cin>>age;
       cout<<"entrez votre titre   :";
       cin>>titre;
       cout<<"entrez votre numero de passport   :";
       cin>>npassport;
       cout<<"est ce que vous voulez confirmer (oui/non) :";
       cin>>rep;
       if(rep=="oui")
       confirme=true;
       else
     confirme=false;
     }

void voyageur::confirmation()
      {
        string rep;
         cout<<"est ce que vous voulez vraiment confirmer votre reservation (oui/non)";
          cin>>rep;
          if(rep=="oui")
          confirme=true;
    }


void voyageur::affiche()
     {
      cout<<"nom       : "<<nom<<endl;
      cout<<"prenom    : "<<prenom<<endl;
      cout<<"age       : "<<age<<endl;
      cout<<"titre      : "<<titre<<endl;
      if(confirme==true)
      cout<<"avec confirmation"<<endl;
      else
     cout<<"sans confirmation"<<endl;
    }

string voyageur::get_npass()
     {
      return npassport;
     }

void voyageur::ecrire_fichier(fstream &fichier)
    {
    fichier<<nom<<"\t"<<prenom<<"\t"<<age<<"\t"<<titre<<"\t"<<npassport<<endl;
    }

void voyageur::lire_fichier(fstream &fichier)
     {
          fichier>>nom>>prenom>>age>>titre>>npassport;
          }

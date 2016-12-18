#include<iostream>
#include<fstream>
#include<string>
#include"destination.h"
using namespace std;

destination::destination()
      {
       }
destination::destination(string dep,string arv)
       {
        depart=dep;
         arrivee=arv;
        }
string destination::get_depart()
       {
         return depart;
        }
string destination::get_arrivee()
       {
            return arrivee;
           }
void destination::dest()
        {
        cout<<"entrez la ville de depart :";
         cin>>depart;
         cout<<"entrez la ville d'arrivée :";
         cin>>arrivee;
          }
void destination::afficher()
       {
        cout<<"  \t"<<depart;
         cout<<"\t"<<arrivee;
       }
void destination::lire_fichier(fstream &fichier)
       {
       fichier>>depart>>arrivee;
        }

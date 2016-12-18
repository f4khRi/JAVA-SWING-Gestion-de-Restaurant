#include<string>
#include<iostream>
#include<fstream>
#include<vector>
#include<time.h>
#include"date.h"
#include"prix.h"
#include"vol.h"
#include"destination.h"
#include"voyageur.h"
using namespace std;
vol::vol()
       {
    nb_res=0;
      }
vol::vol(string num)
            {
    n_vol=num;
        }
void vol::confirmer(int pos)
         {
           passager[pos].confirmation();
          }
void vol::annuller_reservation(int pos)
       {
          passager[pos]=passager[passager.size()-1];
           passager.pop_back();
       }
 bool vol::recherche(const vector<vol> &vols)
        {
           unsigned i=0;
            unsigned trouve=false;
         while(i<vols.size() && trouve==false)
           {
               if(vols[i].n_vol==n_vol)
                trouve=true;
                  else
                 i++;
            }
         return trouve;
     }
bool vol::recherche(const vector<vol> &vols,int &pos)
          {unsigned i=0;
           unsigned trouve=false;
           while(i<vols.size() && trouve==false)
           {
             if(vols[i].n_vol==n_vol)
            {
               trouve=true;
                pos=i;
               }
              else
                 i++;
             }
          return trouve;
}
bool vol::recherche_pass(string nn,int &pos)
      {unsigned i=0;
         unsigned trouve=false;
           while(i<passager.size() && trouve==false)
           {
             if(passager[i].get_npass()==nn)
             {
             trouve=true;
             pos=i;
         }
               else
                 i++;
              }
          return trouve;
}
void vol::ajout_vol(string num,unsigned nb)
         {
           time_t temps;
            struct tm * t;
              nb_p=nb;
               n_vol=num;
               m_date.amj();
               m_date.heurs();
               temps=time(NULL);
                 t = localtime(&temps);
               while(!controle_date(t->tm_year,t->tm_mon,t->tm_mday,t->tm_hour,
                   t->tm_min))
                 {
                  cout<<" erreur !!!\a\a ce date est deja depasser !!!!"<<endl;
                  m_date.amj();
                 m_date.heurs();
                  temps=time(NULL);
                    t = localtime(&temps);
                   }
            m_prix.prixv();
                 m_destination.dest();
          }
void vol::modifier_date()
               {
              m_date.amj();
               }
void vol::modifier_heur()
            {
             m_date.heurs();
            }
void vol::afficher()
       {
           cout<<"  "<<n_vol<<"\t\t"<<m_destination.get_depart()<<"\t\t"<<m_destination.get_arrivee()<<"\t\t"<<m_date.afficher() <<"\t\t"<<m_prix.get_prix()<<endl;
       }
void vol::afficher_pass()
            {
             cout<<"numero de vol est :"<<n_vol<<endl;
              if(passager.empty())  // Si le tableau est vide.
                {
                  cout<<" aucun reservation !!!!!"<<endl;
                }
                else
                {
                 for(unsigned i=0;i<passager.size();i++)
                 passager[i].affiche();
                  }
       }
void vol::reserver()
       {
    voyageur xxx;
                    if(passager.size()==nb_p)
                        cout<<"vous ne pouvez pas reserver la vol est pleinne !!!!!!"<<endl;
                    else
                    {
                     passager.push_back(xxx);
                    passager[passager.size()-1].reservation();
                    }
                    nb_res=passager.size();
       }
void vol::ecrire_fichier(fstream &fichier)
         {
   fichier <<n_vol<<"\t"<<m_destination.get_depart()<<"\t"<<             m_destination.get_arrivee()<<"\t"<<m_prix.get_prix()<<"\t";
        m_date.ecrire_fichier(fichier);
       fichier<<nb_res<<endl;
       for(unsigned i=0;i<passager.size();i++)
       passager[i].ecrire_fichier(fichier);
        }
void vol::lire_fichier(fstream &fichier)
        {
    voyageur vvv;
  fichier >>n_vol;
  m_destination.lire_fichier(fichier);
  m_prix.lire_fichier(fichier);
  m_date.lire_fichier(fichier);
  fichier>>nb_res;
  for(unsigned i=0;i<nb_res;i++)
  {
      passager.push_back(vvv);
      passager[i].lire_fichier(fichier);
  }
}
bool vol::controle_date(int a,int m,int j,int h,int mi)
       {
             return m_date.controle_date(a,m,j,h,m);
         }

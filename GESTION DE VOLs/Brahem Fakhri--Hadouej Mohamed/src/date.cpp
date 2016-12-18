#include<iostream>
#include<stdlib.h>
#include<fstream>
#include<string>
#include<string.h>
#include"date.h"
using namespace std;

date::date()
     {
     }

date::date(int j,int m,int a,int h,int mi)
    {
    jour=j;
    mois=m;
    annee=a;
    heur=h;
    min=mi;
    }


void date::amj()
     {
      cout<< " ******* la date  jj/mm/aaaa  hh:mm ******** "<<endl;
     cout<<"entrez le jour (jj) :";
     cin>>jour;
     while(jour<1 || jour>31)
     {  cout<<" erreur !!!!! \a\a\nreentrez le jour (jj) :";
      cin>>jour;
      }

    cout<<"entrez le mois (mm) :";
    cin>>mois;
    while(mois<1 || mois>12)
    {cout<<" erreur !!!!! \a\a \nreentrez le mois (mm) :";
    cin>>mois;
    }
    cout<<"entrez l'annee (aaaa) :";
    cin>>annee;
    while(annee<2010 || jour>2030)
    {cout<<" erreur !!!!! \a\a \nreentrez l'annee (aaaa) :";
    cin>>annee;
    }
  }

     void date::heurs()
   {
    cout<<"entre l'heur (hh)    : ";
    cin>>heur;
    while(heur<0 || jour>23)
    {
       cout<<" erreur !!!!! \a\a reentrez l'heur (hh) :";
       cin>>heur;
    }
    cout<<"entre les minites (mm)    : ";
    cin>>min;
    while(min<0 || min>59)
    {cout<<" erreur !!!!! \a\a reentrez les minute (mm) :";
    cin>>min;
    }
}

string date::afficher()
{
    char ch[6],chaine[20];
    itoa(jour,ch,10);
    strcpy(chaine,ch);
    strcat(chaine,"/");

     itoa(mois,ch,10);
    strcat(chaine,ch);
    strcat(chaine,"/");

     itoa(annee,ch,10);
    strcat(chaine,ch);
    strcat(chaine," ");

     itoa(heur,ch,10);
    strcat(chaine,ch);
    strcat(chaine,":");

     itoa(min,ch,10);
    strcat(chaine,ch);

 return chaine;
}

bool date::controle_date(int a,int m,int j,int h,int mi)
{
    if(annee<1900+a||( annee==1900+a && mois<m) || (annee==1900+a && mois==m && jour<j)||(annee==1900+a && mois==m && jour==j && heur<h) ||(annee==1900+a && mois==m && jour==j && heur==h && min<mi))
    return false;
    else
    return true;
}


void date::ecrire_fichier(fstream &fichier)
{
    fichier<<jour<<" "<<mois<<" "<<annee<<" "<<heur<<" "<<min<<endl;
}

void date::lire_fichier(fstream &fichier)
{
    fichier>>jour>>mois>>annee>>heur>>min;
}

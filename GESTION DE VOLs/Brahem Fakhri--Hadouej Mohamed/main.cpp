#include <iostream>
#include<vector>
#include<string>
#include"vol.h"

using namespace std;
int main()
{

     int choix;
      unsigned i=0;
    vector<vol> liste;
    vol v;
    using namespace std;
    	for (int i = 0; i<100; i++)
	{
		cout << "chargement de donnees: " << i << " %";
		Sleep(50);
		system("cls");
	}

    std::fstream f;
    f.open("vol.txt", ios::in | ios::out | ios::trunc);
                 if(! f.is_open()) exit (-1);
      while(1)
    {

        system("cls");
    cout<<"                ___________________     M E N U      _______________________"<<endl;
    cout<<"               |                                                           |"<<endl;
    cout<<"               |  1  ------------   Liste des vols   --------------------  |"<<endl;
    cout<<"               |  2  ------------   rechercher un vol  -----------------   |"<<endl;
    cout<<"               |  3  ------------- Enregistrer un vol ------------------   |"<<endl;
    cout<<"               |  4  ------------   Modifier un vol   ------------------   |"<<endl;
    cout<<"               |  5  ------------   Reserver un vol     ----------------   |"<<endl;
    cout<<"               |  6  ------------  Recherche passager-------------------   |"<<endl;
    cout<<"               |  7  --------Afficher la liste des passagers-------------  |"<<endl;
    cout<<"               |  8  ------------        QUITTER       --------------------|"<<endl;
    cout<<"               |___________________________________________________________|"<<endl;

    cout<<"\n entrez votre choix :";
    cin>>choix;
    while(choix<1 || choix>8)
    {
        cout<<"\n votre choix est eronne \a\a !!!!!!"<<endl;
        cout<<"reentrez votre choix :";
        cin>>choix;
    }
    switch(choix)
    {
        case 1 :if(liste.empty())
                     cout<<" Aucun vol n'est disponible maintenant !!!!"<<endl;

                else
                {
                 system("cls");
                 cout<<"                     ***********  Les vols disponibles  ************\n\n\n";
                 for(i=0;i<liste.size();i++)
                 {
                     liste[i].afficher();
                 }
                 }
                 cout<<"\n\n";
                 system("pause");break;
        case 2 :
                  if(liste.empty())
                     cout<<" Aucun vol n'est disponible maintenant !!!!"<<endl;

                else
                {
                    string nm;
                    cout<<"entrez le num de vol que vous voulez chercher : ";
                    cin>>nm;
                 system("cls");
                 int i;
                 v.recherche(liste,i);
                 if(i==-1)
                 cout<<"\n\n ce vol n'existe pas dans la liste\n";
                 else
                  liste[i].afficher();

                 }
                 cout<<"\n\n";
                 system("pause");break;
        case 3 :
            {
                string ch;
                 cout<<"\n saisir le numero du vol a ajouter : "<<endl;
                 cin>>ch;
                 int nb;
                 cout<<"\n saisir le nbre de place : "<<endl;
                 cin>>nb;
                 v.ajout_vol(ch,nb);
                 liste.push_back(v);
                 system("pause");
                 system("cli"); break;
            }
        case 4 :
             if(liste.empty())
                      cout<<"\n \n Aucun vol n'est disponible maintenant !!!!"<<endl;


                else
                {
                    string nm,tel;
                    cout<<"entrez le num de vol que vous voulez modifier : ";
                    cin>>nm;
                 system("cls");
                  int i;
                 v.recherche(liste,i);
                 if(i==-1)
                 cout<<"\n\n ce vol n'existe pas dans la liste\n";
                 else
                 {
                  liste[i].modifier_date();
                  liste[i].modifier_heur();

                 }

                 }
                 cout<<"\n\n";
                 system("pause");break;

        case 5 :
            int nm;
            cout<<"entrez le num de vol que vous voulez reserver : ";
            cin>>nm;
            system("cls");
                  int i;
                 v.recherche(liste,i);
                 if(i==-1)
                 cout<<"\n\n ce vol n'existe pas dans la liste\n";
                 else
                 {
                  liste[i].reserver();
                 }
                 system("pause");break;
        case 6:
{
             if(liste.empty())
                      cout<<"\n \n Aucun vol n'est disponible maintenant !!!!"<<endl;


                else
                {
                    string ch;
                    int pos;
                    cout<<"\n saisir le nom du passager :"<<endl;
                    cin>>ch;
                    for(unsigned i=0;i<liste.size();i++)
                    {
                    liste[i].recherche_pass(ch,pos);
                    if (pos!=-1) break;
                    }
                    if (pos!=-1) cout<<"\n passager trouve !! "<<endl;
                }


                 system("pause");break;
}
        case 7 :
            {
                 if(liste.empty())
                      cout<<"\n \n Aucun vol n'est disponible maintenant !!!!"<<endl;


                else
                {
                    string nm;
                    cout<<"entrez le num de vol que vous voulez chercher : ";
                    cin>>nm;
                 system("cls");
                 int i;
                 v.recherche(liste,i);
                 if(i==-1)
                 cout<<"\n\n ce vol n'existe pas dans la liste\n";
                 else
                  liste[i].afficher_pass();

                 }
                 cout<<"\n\n";
                 system("pause");break;

            }
            case 8 :
                {
			fstream f;//enregistrement de liste des voyages
			f.open("vol.txt", ios::in | ios::out | ios::trunc);
			if (!f.is_open()) cout << "erreur d'ouverture du fichier" << endl;
			else
				f.seekg(0);
            for(unsigned i=0;i<liste.size();i++)
			       liste[i].ecrire_fichier(f);
			f.close();
		}
                exit(-1);
    }
    }
    f.close();
    return 0;
}


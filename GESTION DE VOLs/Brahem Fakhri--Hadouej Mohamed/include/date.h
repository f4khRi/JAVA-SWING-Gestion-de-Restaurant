#ifndef DATE_H
#define DATE_H


class date
{  public:
  date();
  date(int j,int m,int a,int h,int mi);
  void amj();
  void heurs();
  std::string afficher();
  bool controle_date(int a,int m,int j,int h,int mi);
  void ecrire_fichier(std::fstream &fichier);
  void lire_fichier(std::fstream &fichier);
private:
  int jour,mois,annee,heur,min;
};

#endif // DATE_H

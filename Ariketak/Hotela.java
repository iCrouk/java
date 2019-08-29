class Hotela{
  String izena;
  int maxOstatutar;
  Zuzendaria zuzendaria;
  gelak Gela[][];
  int solairuak;


Hotela (String izena, int gelakop, int sol){
  int akum;
  izena=izena;
  gelak=new Gela[sol][gelakop];
  for (int i=0; i<sol; i++){
    for (int j=0; j<gelakop; j++){
      switch (sol){
        case 1:
          zenb=i*100+j;
          solairua=i;
          bikoitza=false;
          edukiera=1;
          akum=j + akum;
          break;
        case 2:
          zenb=i*100+j;
          solairua=i;
          bikoitza=true;
          edukiera=2;
          akum=akum + 2*j;
          break;
        case 3:
          zenb=i*100+j;
          solairua=i;
          bikoitza=false;
          edukiera=3;
          akum=akum + 3*j;
          break;
        case >=4:
          zenb=i*100+j;
          solairua=i;
          bikoitza=true;
          edukiera=2;
          akum=akum + 2*j;}}}
  maxOstatutar=akum;}
          
      
      
int getMaxOstatutar(){
  return maxOstatutar;}


String getIzena(){
  return izena;}


int harreraEgin (boolean b,int e){
  System.out.println ("Ongi etorri "+izena+" hotelera.");
  System.out println ("Gure edukiera "+maxOstatutar+" bezero jasotzeko prestatuta dago.");
  agurtuBezeroa();
  for (int j=0; j<sol; j++){
      for(int i=0; i<gelakop; i++)
        if (okupatua==false){
          Gela[e][i].okupatua=true;
          break;}
    case 2:
      for(int i=0; i<gelakop; i++)
        if (okupatua==false){
          Gela[e][i].okupatua=true;
          break;}
    case 3:
      for(int i=0; i<gelakop; i++)
        if (okupatua==false){
          Gela[e][i].okupatua=true;
          break;}
    case >=4:
      for(int i=0; i<gelakop; i++)
        if (okupatua==false){
          Gela[e][i].okupatua=true;
          break;}}


void irteeraKudeatu(zenb){
  int x=zenb
  
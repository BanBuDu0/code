#include<stdio.h>
int main(void){
  int a,i=0;
  scanf("%d",&a);
  while(a>1){
    a=(a%2==0)?a/2:(3*a+1)/2;
    i++;
  }
  printf("%d",i);
  return 0;
}
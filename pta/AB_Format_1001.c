#include<stdio.h>
#include<math.h>
int main(){
    int m,a,b;
    scanf("%d %d",&a,&b);
    m = a+b;
    if (m<0){printf("-");m=-m;}
    if (m>=1000000){
        printf("%d,%03d,%03d",m/1000000,(m/1000)%1000,(m%1000));
    }else if (m>=1000){
        printf("%d,%03d",m/1000,m%1000);
    }else {
        printf("%d",m);
    }
}


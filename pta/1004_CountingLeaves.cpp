#include<iostream>
#include<vector>
using namespace std;

/*
input N M
2 1
ID K ID[1] ID[2]
01 1 02

output  di i ceng de yezi jiedian
0 1
*/

//-3
int main(){
	int N, M;
	cin >> N >> M;
	int ID[100][100];
	int id, childs;
	for(int i = 0; i < M; i ++){
		cin >> id >> childs;
		ID[i][0] = id;
		for(int j = 0; j < childs; j ++){
		    int node = 0;
		    cin >> node;
			ID[i][j] = node;
		}
	}
	int* output = new int[M + 1];
	if(N == 1){
		output[0] = 1;
	}else{
		output[0] = 0;
	}
	for(int i = 0; i < M; i ++){
		output[i + 1] = 0;
		for(int j = 0; j < childs; j ++){
			output[ i + 1] ++;
			for(int z = 0; z < M; z ++){
				if(ID[i][j + 1] == ID[z][0]){
					output[ i + 1] --;
				}
			}
		}
	}
	cout << output[0];
	for(int i = 1; i < M + 1; i ++){
		cout << " " << output[i];
	}


}

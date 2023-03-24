#include<iostream>
#include<stdio.h>
#include<fstream>
#include<string>
#include<stdlib.h>
#include<string.h>
#include<cstring>
#include <conio.h>
#include <windows.h>
#include<assert.h>
#include<iomanip>
#include"schoolmap.h"
#define INF 10000

using namespace std;


int main()
{
	schoolmap schmap;
	string v1, v2;
	int w;
	ifstream infile;
	infile.open("map.txt");
	assert(infile.is_open());
	
	while (!infile.eof())
	{
		infile >> schmap.vernum >> schmap.edgenum;

		for (int h = 1; h <= schmap.vernum; h++)
			infile >> schmap.ver[h].sitename >> schmap.ver[h].siteintroduce;

        for (int i = 1; i <= schmap.vernum; i++)           //ÁÚ½Ó¾ØÕó³õÊ¼»¯
			for (int j = 1; j <= schmap.vernum; j++)
				schmap.AdjMatrix[i][j] = INF;

		for (int k = 1; k <= schmap.edgenum; k++)
		{
			infile >> v1 >> v2 >> w;
				schmap.edg[k].start = v1;
				schmap.edg[k].end = v2;
				schmap.edg[k].weight = w;
			for(int i=1;i<=schmap.vernum;i++)           
				for (int j = 1; j <= schmap.vernum; j++)
				{
					int m = LocateVex(schmap, v1);
					int n = LocateVex(schmap, v2);
					schmap.AdjMatrix[m][n] = w;
					schmap.AdjMatrix[n][m] = w;
				}
		}
		infile.close();
	}
	Printmain(schmap);

	return 0;
}
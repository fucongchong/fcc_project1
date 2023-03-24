#pragma once
#include<iostream>
#include<stdio.h>
#include<fstream>
#include<string>
#include<stdlib.h>
#include<string.h>
#include<cstring>
#include <conio.h>
#include <windows.h>
#define INF 10000
using namespace std;


typedef struct
{
	string sitename;  //��������
	string siteintroduce;  //������
}Site;

typedef struct
{
	string start; //�����
	string end;   //���յ�
	int weight;   //�ߵ�Ȩ
}EdgeSets[100];

typedef struct
{
	Site ver[100];  //��������
	EdgeSets edg;    //��ߵ�����
	int vernum, edgenum; //����������ߵ�����
	int AdjMatrix[100][100];//�ڽӾ���
}schoolmap;

void color(short x);                         //����ɫ��ӡ        
int LocateVex(schoolmap &s, string u);       //�������ƻ�ȡ�ڱ������е��±�
void SaveFile(schoolmap &s, string filename); //���޸���Ϣ����txt�ļ�

void Printmain(schoolmap &s);        //�������������

void PrintSubsystem(schoolmap &s);   //ǰ̨��ϵͳ
void PrintFind(schoolmap &s);       //������Ϣ��ѯ
void FindName(schoolmap &s);       //�������Ʋ�ѯ
void FindFunction(schoolmap &s);    //�����ܲ���
int KMP(char *str, int slen, char *ptr, int plen);
void cal_next(char *str, int *next, int len);   //KMP����next

void FindWay(schoolmap &s);        //��·��ѯ
void FindWay_all(schoolmap &s);     //�����������·��
void FindWay_shortest(schoolmap &s);  //����������·��
void Dijkstra(int start,int end, int *path, int *dis, int *visit, schoolmap &s);
void searchPath(int now_place, int start, int *path, schoolmap &s);
void DFS(int now, int st, int ed, int sum, int *path, int *dis, int *visit, bool DfsPath,int initialize, schoolmap &s);

void PrintBackground(schoolmap &s);  //��̨����ϵͳ
void in_password(char *password);    //�����뺯��
void PrintBackground_afterlogin_menu(schoolmap &s);  //��̨��¼�ɹ�����
void AddSite(schoolmap &s);                  //����һ������
void ModifySite(schoolmap &s);           //���ľ�����Ϣ
void DeleteSite(schoolmap &s);               //ɾ��һ������
void AddEdge(schoolmap &s);                 //����һ����
void DeleteEdge(schoolmap &s);              //ɾ��һ���߽���
void delete_edge(schoolmap &s, int pos);//ɾ���ߵĺ���







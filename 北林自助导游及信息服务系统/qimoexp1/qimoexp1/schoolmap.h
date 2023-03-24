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
	string sitename;  //景点名称
	string siteintroduce;  //景点简介
}Site;

typedef struct
{
	string start; //边起点
	string end;   //边终点
	int weight;   //边的权
}EdgeSets[100];

typedef struct
{
	Site ver[100];  //存点的数组
	EdgeSets edg;    //存边的数组
	int vernum, edgenum; //点的数量，边的数量
	int AdjMatrix[100][100];//邻接矩阵
}schoolmap;

void color(short x);                         //换颜色打印        
int LocateVex(schoolmap &s, string u);       //更具名称获取在边数组中的下标
void SaveFile(schoolmap &s, string filename); //将修改信息存入txt文件

void Printmain(schoolmap &s);        //进入界面主函数

void PrintSubsystem(schoolmap &s);   //前台子系统
void PrintFind(schoolmap &s);       //景点信息查询
void FindName(schoolmap &s);       //景点名称查询
void FindFunction(schoolmap &s);    //按功能查找
int KMP(char *str, int slen, char *ptr, int plen);
void cal_next(char *str, int *next, int len);   //KMP所需next

void FindWay(schoolmap &s);        //问路查询
void FindWay_all(schoolmap &s);     //找两点间所有路径
void FindWay_shortest(schoolmap &s);  //找两点间最短路径
void Dijkstra(int start,int end, int *path, int *dis, int *visit, schoolmap &s);
void searchPath(int now_place, int start, int *path, schoolmap &s);
void DFS(int now, int st, int ed, int sum, int *path, int *dis, int *visit, bool DfsPath,int initialize, schoolmap &s);

void PrintBackground(schoolmap &s);  //后台管理系统
void in_password(char *password);    //输密码函数
void PrintBackground_afterlogin_menu(schoolmap &s);  //后台登录成功界面
void AddSite(schoolmap &s);                  //增加一个景点
void ModifySite(schoolmap &s);           //更改景点信息
void DeleteSite(schoolmap &s);               //删除一个顶点
void AddEdge(schoolmap &s);                 //增加一条边
void DeleteEdge(schoolmap &s);              //删除一条边界面
void delete_edge(schoolmap &s, int pos);//删除边的函数







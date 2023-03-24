#include<iostream>
#include<stdio.h>
#include<fstream>
#include<string>
#include <cstring>
#include<stdlib.h>
#include<string.h>
#include<cstring>
#include <conio.h>
#include <windows.h>
#include"schoolmap.h"        
#define INF 10000

using namespace std;

void SaveFile(schoolmap &s,string filename)
{
	ofstream ofile;
	ofile.open(filename);
	ofile << s.vernum << " "<<s.edgenum<<endl;
	for (int h =1; h <= s.vernum; h++)
		ofile << s.ver[h].sitename <<" "<< s.ver[h].siteintroduce << endl;;
	for(int i=1;i<=s.edgenum;i++)
				ofile << s.edg[i].start << " " << s.edg[i].end << " " << s.edg[i].weight << endl;
	
	ofile.close();
}
void color(short x)	//自定义函根据参数改变颜色 
{
	if (x >= 0 && x <= 15)//参数在0-15的范围颜色
		SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), x);	//只有一个参数，改变字体颜色 
	else//默认的颜色白色
		SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
}
int LocateVex(schoolmap &s, string u)
{
	int i;
	for (i = 1; i <= s.vernum; i++)
		if (u == s.ver[i].sitename)
			return i;
	return false;
}

void Printmain(schoolmap &s)
{
		cout << "/****************** 北林自助导游及信息服务系统********************/" << endl;
		cout << endl;
		cout << "------------------------";
		color(6); 
		cout << "主界面";
		color(16);
		cout<<"-----------------------------" << endl;
		cout << "1.前台服务" << endl;
		cout << "2.后台管理" << endl;
		cout << "0.退出系统" << endl;
		int inputnum;
		cin >> inputnum;
		switch (inputnum)
		{
		case 0:
		{
			SaveFile(s, "map.txt");
			exit(0);
		}
		case 1:
		{
			system("cls");    //清除之前显示的窗口
			PrintSubsystem(s);
		}
		case 2:
		{
			system("cls");
			PrintBackground(s);

		}
		default:
		{
			SaveFile(s, "map.txt");
			cout << "ERRO!!!!!!!!!!!!!!!!!" << endl;
		}
		}
}

void PrintSubsystem(schoolmap &s)
{
	
	
		cout << "/****************** 北林自助导游及信息服务系统********************/" << endl;
		cout << endl;
		cout << "--------------------------";
		color(6);
		cout << "前台服务子系统";
		color(16);
		cout<<"---------------------------- " << endl;
		cout << "1.景点信息查询" << endl;
		cout << "2.问路查询" << endl;
		cout << "0.返回" << endl;
		int num2;
		cin >> num2;
		switch (num2)
		{
		case 0:
		{
			system("cls");
			Printmain(s);
		}
		case 1:
		{
			system("cls");
			PrintFind(s);
			
		}
		case 2:
		{
			system("cls");
			FindWay(s);
			
		}
		default:
			cout << "ERRO!!!!!!!!!!!!!!!!!!!!!!" << endl;
		}
		
		
	

}
void PrintFind(schoolmap &s)
{
		cout << "/****************** 北林自助导游及信息服务系统********************/" << endl;
		cout << endl;
		cout << "-----------------------------";
		color(6);
		cout << "前台服务子系统——景点信息查询";
		color(16);
		cout<<"----------------------" << endl;
		cout << "1.根据景点名称查询" << endl;
		cout << "2.根据景点功能查询" << endl;
		cout << "0.返回" << endl;
		int num3 = 10;
		cin >> num3;
		switch (num3)
		{
		case 0:
		{
				system("cls");
				PrintSubsystem(s);
		}
		case 1: 
		{
			system("cls");
             FindName(s);
		}
				
		case 2:
		{
			system("cls");
			FindFunction(s);
		}
		}
}
void FindName(schoolmap &s)
{
	
		cout << "/****************** 北林自助导游及信息服务系统********************/" << endl;
		cout << endl;
		cout << "-----------------------------";
		color(6);
		cout << "前台服务子系统——根据景点名称查询";
		color(16);
		cout<<"----------------------" << endl;
		cout << "本系统提供以下景点服务：" << endl;
		int f = 0;
		for (int i = 1; i <= s.vernum; i++)
		{
			cout << s.ver[i].sitename << "     ";
			f++;
			if (f%4==0)
				cout << endl;
		}
		cout << endl;
		cout << "请输入要查询景点的名称：" << endl;
		string sear;
		cin >> sear;
		for (int i = 0; i < s.vernum; i++)
		{
			if (sear == s.ver[i].sitename)
			{
				cout << s.ver[i].sitename << "的相关信息为：" << endl;
				cout << s.ver[i].siteintroduce << endl;
			}
		}
		cout << endl;
		cout << "按任意键结束本次服务" << endl;
		int flag = 0;
		cin >> flag;
		if (flag != NULL)
		{
			system("cls");
			PrintFind(s);
		}

	

}
void FindFunction(schoolmap &s)
{
	cout << "/****************** 北林自助导游及信息服务系统********************/" << endl;
	cout << endl;
	cout << "-----------------------------";
	color(6);
	cout << "前台服务子系统——根据景点功能查询";
	color(16);
	cout << "----------------------" << endl;
	cout << "请输入待查询景点功能：" << endl;
	string find;
	cin >> find;
	char find_char[100];
	strcpy(find_char, find.c_str());
	for (int i = 0; i < s.vernum; i++)
	{
		string temp = s.ver[i].siteintroduce;
		char temp_char[100];
		strcpy(temp_char, temp.c_str());           //string转char
		if (KMP(temp_char, temp.length(), find_char, find.length()) != -1)
			cout << s.ver[i].sitename << "    ";
	}
	cout << endl;
	cout << "按任意键结束本次服务" << endl;
	getch();
	system("cls");
	PrintFind(s);
}
void cal_next(char *str, int *next, int len)
{
	next[0] = -1;//next[0]初始化为-1，-1表示不存在相同的最大前缀和最大后缀
	int k = -1;//k初始化为-1
	for (int q = 1; q <= len - 1; q++)
	{
		while (k > -1 && str[k + 1] != str[q])//如果下一个不同，那么k就变成next[k]，next[k]是小于k的，无论k取任何值。
		{
			k = next[k];//往前回溯
		}
		if (str[k + 1] == str[q])//如果相同，k++
		{
			k = k + 1;
		}
		next[q] = k;//把算的k的值（就是相同的最大前缀和最大后缀长）赋给next[q]
	}
}
int KMP(char *str, int slen, char *ptr, int plen)  //str主串    ptr子串
{
	int *next = new int[plen];
	cal_next(ptr, next, plen);//计算next数组
	int k = -1;
	for (int i = 0; i < slen; i++)
	{
		while (k >-1 && ptr[k + 1] != str[i])//ptr和str不匹配，且k>-1（表示ptr和str有部分匹配）
			k = next[k];//往前回溯
		if (ptr[k + 1] == str[i])
			k = k + 1;
		if (k == plen - 1)//说明k移动到ptr的最末端
		{
			return i - plen + 1;//返回相应的位置
		}
	}
	return -1;   //匹配失败
}

void FindWay(schoolmap &s)
{
	cout << "/****************** 北林自助导游及信息服务系统********************/" << endl;
	cout << endl;
	cout << "------------------------------";
	color(6);
	cout << "前台服务子系统——问路查询";
	color(16);
	cout << "-------------------------------" << endl;
	cout << "1.查询两个景点间最短路径" << endl;
	cout << "2.查询两个景点间所有路径" << endl;
	cout << "0.返回" << endl;
	int num2;
	cin >> num2;
	switch (num2)
	{
	case 0:
	{
		system("cls");
		PrintSubsystem(s);
	}
	case 1:
	{
		system("cls");
		FindWay_shortest(s);

	}
	case 2:
	{
		system("cls");
		FindWay_all(s);
	}
	default:
		cout << "ERRO!!!!!!!!!!!!!!!!!!!!!!" << endl;
	}
}
void FindWay_all(schoolmap &s)
{
	string start_place, aim_place;
	int path[1000], dis[1000], visit[1000];
	bool DfsPath;
	int initialize;
	cout << "/****************** 北林自助导游及信息服务系统********************/" << endl;
	cout << endl;
	cout << "------------------------------";
	color(6);
	cout << "前台服务子系统——问路查询";
	color(16);
	cout << "-------------------------------" << endl;
	cout << "本系统提供如下景点服务：" << endl;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		if (i % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "共" << s.vernum << "个景点" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "目前已有路径如下：" << endl;
	int fff = 0;
	for (int m = 1; m <= s.edgenum; m++)
	{
		fff++;
		cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
		if (fff % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "共" << s.edgenum << "条路径" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "请输入您的当前位置：" << endl;
	cin >> start_place;
	cout << "请输入您欲前往的地点：" << endl;
	cin >> aim_place;
	cout << endl;
	cout << endl;
	int start_site = LocateVex(s, start_place);//起点
	int aim_site = LocateVex(s, aim_place);//终点
	cout << "这两点间的所有路径为：" << endl;
	cout << endl;
	DfsPath = false;
	initialize = 0;
	DFS(start_site, start_site, aim_site, 0, path, dis, visit, DfsPath, initialize, s);
	cout << endl;
	cout << "-------------------------------------------" << endl;
	cout << "按任意键结束本次服务" << endl;
	getch();
	system("cls");
	PrintSubsystem(s);

}
void FindWay_shortest(schoolmap &s)
{
	string start_place, aim_place;
	int path[1000], dis[1000], visit[1000];
	bool DfsPath;
	cout << "/****************** 北林自助导游及信息服务系统********************/" << endl;
	cout << endl;
	cout << "-------------------------------";
	color(6);
	cout << "前台服务子系统——问路查询";
	color(16);
	cout << "-------------------------------" << endl;
	cout << "本系统提供如下景点服务：" << endl;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		if (i % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "共" << s.vernum << "个景点" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "目前已有路径如下：" << endl;
	int fff = 0;
	for (int m = 1; m <= s.edgenum; m++)
	{
		fff++;
		cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
		if (fff % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "共" << s.edgenum << "条路径" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "-------------------------------------------" << endl;
	cout << "请输入您的当前位置：" << endl;
	cin >> start_place;
	cout << "请输入您欲前往的地点：" << endl;
	cin >> aim_place;
	cout << endl;
	cout << endl;

	int start_site = LocateVex(s, start_place);//起点
	int aim_site = LocateVex(s, aim_place);//终点
	
	cout << "最便捷的游览路线为：" << endl;
	Dijkstra(start_site,aim_site,path,dis,visit,s);
	searchPath(aim_site,start_site,path,s);

	cout << endl;
	cout << "全程长（单位：米）：" << dis[aim_site] << endl;
	cout << "按任意键结束本次服务" << endl;
	getch();
	system("cls");
	PrintSubsystem(s);
}
void DFS(int now, int start, int end, int sum, int *path, int *dis, int *visit,bool DfsPath, int initialize,schoolmap &s)
{
	if (initialize == 0)  //仅第一次初始化
	{
		for (int i = 1; i <= 100; i++)
		{
			path[i] = -1;   // 记录上一节点
			visit[i] = 0;   //是否访问
		}
	}

	if (now == end)
	{
		searchPath(end, start,path, s);
		DfsPath = true;
		cout << "     路径长度为：  " << sum << " (单位：米)       "<<endl;
		cout << endl;
		return;
	}
	visit[now] = 1;
	for (int v = 1; v <= s.vernum; v++)
		if (!visit[v] && s.AdjMatrix[now][v] < INF) 
		{
			int tmp = path[v]; 
			path[v] = now;
			visit[v] = 1;
			initialize++;
			DFS(v, start, end, sum + s.AdjMatrix[now][v], path, dis, visit, DfsPath, initialize, s);
			visit[v] = 0;
			path[v] = tmp;
		}
}
void Dijkstra(int start, int end, int *path, int *dis, int *visit, schoolmap &s)
{
	for (int i = 1; i <= 100; i++)
	{
		dis[i] = INF; //距离源点
		path[i] = -1;   // 记录上一节点
		visit[i] = 0;   //是否访问
	}
	for (int j = 1; j <= s.vernum; j++)
		if (s.AdjMatrix[start][j] < INF)
		{
			dis[j] = s.AdjMatrix[start][j];
			path[j] = start;
		}
	dis[start] = 0;//到自身为0
	for (int i = 1; i <= s.vernum; i++)
	{
		int mn = INF, cur;
		for (int j = 1; j <= s.vernum; j++)
			if (!visit[j] && dis[j] < mn)
			{
				mn = dis[j], cur = j;
			}
		visit[cur] = 1;//已被访问
		for (int k = 1; k <= s.vernum; k++)
			if (dis[k] > dis[cur] + s.AdjMatrix[cur][k])//k到源点的距离大于 当前访问到源点+当前访问到k
			{
				dis[k] = dis[cur] + s.AdjMatrix[cur][k];
				path[k] = cur;
			}
	}
}
void searchPath(int now_place, int start,int *path, schoolmap &s)
{
	if (now_place == start)
	{
		cout << s.ver[start].sitename;  //从起点开始打印
		return;
	}
	searchPath(path[now_place], start,path, s);
	cout << "-->" << s.ver[now_place].sitename; //最后打印到所求的当前点
}

void PrintBackground(schoolmap &s)
{
	cout << "/****************** 北林自助导游及信息服务系统********************/" << endl;
	cout << endl;
	cout << "-----------------------------";
	color(6);
	cout << "后台管理子系统";
	color(16);
	cout << "----------------------" << endl;
	cout << "请输入登录密码：" << endl;
	char log_in[25];
	char password[25] = "666666";
	int k = 3;
	for (k = 3; k > 0; k--)
	{
		in_password(log_in);
		if (strcmp(log_in, password) == 0)
		{
			cout << endl;
			cout << "登录成功" << endl;
			system("cls");
			PrintBackground_afterlogin_menu(s);
		}
		else
		{
			if (k > 1)
			{
				cout << endl;
				cout << "密码错误，你还有" << k - 1 << "次输入机会" << endl;
			}
		}
	}
	cout << endl;
	cout << "--------------------------------------------------" << endl;
	cout << "密码错误，按任意键退出！" << endl;
	getchar();
	getchar();
	system("cls");
	Printmain(s);
}
void in_password(char *password)
{
	int i;
	char ch;
	while (1) {
		i = 0;
		while (1) {
			ch = getch();
			if (ch == '\r')
				break;
			else if (ch == '\b') {
				if (i > 0) {
					printf("\b \b");
					i--;
				}
				continue;
			}
			printf("*");
			password[i++] = ch;
		}
		password[i] = 0;
		break;
	}
}
void PrintBackground_afterlogin_menu(schoolmap &s)
{
	cout << "/****************** 北林自助导游及信息服务系统********************/" << endl;
	cout << endl;
	cout << "-----------------------------";
	color(6);
	cout << "后台管理子系统";
	color(16);
	cout << "-----------------------------" << endl;
	cout << "1.修改一个已有景点的相关信息" << endl;
	cout << "2.增加一个新景点及其相关信息" << endl;
	cout << "3.增加一条新的路径" << endl;
	cout << "4.删除一个景点及其相关信息" << endl;
	cout << "5.删除一条路径" << endl;
	cout << "0.返回主界面" << endl;
	int num6;
	cin >> num6;
	switch (num6)
	{
	case 0:
	{
		system("cls");
		Printmain(s);
	}
	case 1:
	{
		system("cls");
		ModifySite(s);
	}
	case 2:
	{
		system("cls");
		AddSite(s);
	}
	case 3:
	{
		system("cls");
		AddEdge(s);
	}
	case 4:
	{
		system("cls");
		DeleteSite(s);
	}
	case 5:
	{
		system("cls");
		DeleteEdge(s);
	}
	}
}
void ModifySite(schoolmap &s)
{
	string modify_name;
	cout << "--------------------------";
	color(6);
	cout << "后台管理子系统——景点信息修改";
	color(16);
	cout << "---------------------------" << endl;
	cout << "本系统将提供以下景点服务：" << endl;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		if (i % 4 == 0)
			cout << endl;
	}
	int flag = 0;
	cout << endl;
	cout << "请输入要修改的景点名称：" << endl;
	cin >> modify_name;
	for (int i = 1; i <= s.vernum; i++)
	{
		if (modify_name == s.ver[i].sitename)
		{
			flag = 1;
			cout << "您将修改的景点名称为：" << s.ver[i].sitename << endl;
			cout << "请输入您欲修改景点的介绍内容：" << endl;
			cin >> s.ver[i].siteintroduce;
			cout << "您已经将景点  " << s.ver[i].sitename << "  的信息修改为:" << endl;
			cout << s.ver[i].siteintroduce << endl;
			cout << "---------------------------" << endl;
			cout << "按任意键结束本次服务" << endl;
			getchar();
			getchar();
			system("cls");
			PrintBackground_afterlogin_menu(s);
		}
	}
	if (flag == 0)
	{
		cout << "您输入的信息有误，请查清后重新输入欲修改的景点名称：" << endl;
		ModifySite(s);
	}
}
void AddSite(schoolmap &s)
{
	string newsite_name, newsite_introduce;
	string v1, v2;
	cout << "--------------------------";
	color(6);
	cout << "后台管理子系统——景点信息增加";
	color(16);
	cout << "---------------------------" << endl;
	cout << "目前已有景点如下：" << endl;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		if (i % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "共" << s.vernum << "个" << endl;
	cout << "请输入要增加的景点名称和景点简介：" << endl;
	s.vernum = s.vernum + 1;
	cin >> s.ver[s.vernum].sitename >> s.ver[s.vernum].siteintroduce;

	for (int i = 1; i <= s.vernum; i++)
	{
		s.AdjMatrix[i][s.vernum] = INF;
	}
	for (int j = 1; j <= s.vernum; j++)    //图初始化
	{
		s.AdjMatrix[s.vernum][j] = INF;
	}


	cout << "目前有以下共 " << s.vernum << " 个景点：" << endl;
	int k = 0;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		k++;
		if (k % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "按任意键结束本次服务" << endl;
	getchar();
	getchar();
	system("cls");
	PrintBackground_afterlogin_menu(s);
}
void DeleteSite(schoolmap &s)
{
	string deletesite_name, temp_name, temp_introduce;
	cout << "--------------------------";
	color(6);
	cout << "后台管理子系统——景点信息删除";
	color(16);
	cout << "---------------------------" << endl;
	cout << "目前已有景点如下：" << endl;
	int f = 0;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		f++;
		if (f % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "共" << s.vernum << "个" << endl;
	cout << "请输入要删除的景点名称" << endl;
	cin >> deletesite_name;
	int flag = 0;
	int delete_site_locate;
	for (int i = 1; i <= s.vernum; i++)
	{
		if (deletesite_name == s.ver[i].sitename)
		{                                              //此时i为删去点的下标
			flag = 1;
			delete_site_locate=i;
			//for (int j = 1; j <= s.vernum; j++)  //邻接矩阵中删去点i所在行，所在列的值为INF（表示该点不是任何边的端点）
			//{
			//	s.AdjMatrix[i][j] = INF;
			//	s.AdjMatrix[j][i] = INF;
			//}
			for (int i = 1; i < delete_site_locate; i++)                     //右上方矩阵左移动
			{
				for (int j = delete_site_locate; j < s.vernum; j++)
				{
					s.AdjMatrix[i][j] = s.AdjMatrix[i][j + 1];
				}
			}
			for (int i = delete_site_locate; i < s.vernum ; i++)             //左下方矩阵上移动
			{
				for (int j = 1; j < delete_site_locate; j++)
				{
					s.AdjMatrix[i][j] = s.AdjMatrix[i + 1][j];
				}
			}
			for (int i = delete_site_locate+1; i < s.vernum; i++)
			{
				for (int j = delete_site_locate; j < s.vernum; j++)
				{
					s.AdjMatrix[i][j] = s.AdjMatrix[i][j + 1];                 //右下方矩阵左移动

				}
			}
			for (int i = delete_site_locate; i < s.vernum; i++)
			{
				for (int j = delete_site_locate; j < s.vernum; j++)
				{
					s.AdjMatrix[i][j] = s.AdjMatrix[i + 1][j];                        //右下方矩阵上移动

				}
			}

			for (int j = i; j < s.vernum; j++)              //将删去的点从存点的数组中删去
			{
				s.ver[j].sitename = s.ver[j + 1].sitename;
				s.ver[j].siteintroduce = s.ver[j + 1].siteintroduce;
			}
			//路径数修改    邻接矩阵中的对应的边得赋值INF，存边的数组得改变，存点的数组得改变
			s.vernum = s.vernum - 1;
			for (int ii =s.edgenum; ii>=1; ii--)  //存边的数组中与该点有关的边都删去
			{
				if (deletesite_name == s.edg[ii].start || deletesite_name == s.edg[ii].end) //在数组中找到该删除的边
					delete_edge(s, ii);                           //立即删除,删除后，边数组中的位置变了，同时函数中也是边数变了
			}
			s.edgenum = s.edgenum;
			cout << endl;
			cout << "您删除了一个景点后，目前有以下共 " << s.vernum << " 个景点：" << endl;
			for (int i = 1; i <= s.vernum; i++)
			{
				cout << s.ver[i].sitename << "     ";
				if (i % 4 == 0)
					cout << endl;
			}
			cout << endl;
			cout << "-----------------------------------------------" << endl;
			cout << "您删除了一个景点后，目前有以下共 " << s.edgenum << " 条路径" << endl;
			for (int m = 1; m <= s.edgenum; m++)
			{
				cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
				if (m % 4 == 0)
					cout << endl;
			}
			cout << endl;
			cout << "按任意键结束本次服务" << endl;
			getchar();
			getchar();
			system("cls");
			PrintBackground_afterlogin_menu(s);
		}
	}
	if (flag == 0)
	{
		cout << "没有此景点，请重新输入：" << endl;
		DeleteSite(s);
	}
}
void delete_edge(schoolmap &s, int pos)
{
	for (int i = pos; i < s.edgenum; i++)
		s.edg[i] = s.edg[i + 1];
	s.edgenum--;
}
void DeleteEdge(schoolmap &s)
{
	string delete_start_name, delete_end_name;
	int aa, bb;
	cout << "--------------------------";
	color(6);
	cout << "后台管理子系统——路径增加";
	color(16);
	cout << "--------------------------" << endl;
	cout << "目前已有路径如下：" << endl;
	for (int m = 1; m <= s.edgenum; m++)
	{
		cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
		if (m % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "共" << s.edgenum << "条路径" << endl;
	cout << "请输入要删除的路径的起点和终点：" << endl;
	cin >> delete_start_name >> delete_end_name;
	aa = LocateVex(s, delete_start_name);       //在邻接矩阵中将将2个点距离定为INF
	bb = LocateVex(s, delete_end_name);
	s.AdjMatrix[aa][bb] = INF;
	s.AdjMatrix[bb][aa] = INF;
	for (int i = 1; i <= s.edgenum; i++)   //在边数组中覆盖删去的边
	{
		if (delete_start_name == s.edg[i].start&&delete_end_name == s.edg[i].end || delete_start_name == s.edg[i].end&&delete_end_name == s.edg[i].start)
		{
			delete_edge(s, i);
		}
	}
	cout << "您删除了一条路径后，目前已有路径如下：" << endl;
	for (int m = 1; m <= s.edgenum; m++)
	{
		cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
		if (m % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "共" << s.edgenum << "条路径" << endl;
	cout << "按任意键结束本次服务" << endl;
	getchar();
	getchar();
	system("cls");
	PrintBackground_afterlogin_menu(s);
}
void AddEdge(schoolmap &s)
{
	string new_start, new_end;
	int new_weight;
	int ii, jj;
	cout << "--------------------------";
	color(6);
	cout << "后台管理子系统——路径增加";
	color(16);
	cout << "--------------------------" << endl;
	cout << "目前已有景点如下：" << endl;
	int f = 0;
	for (int i = 1; i <= s.vernum; i++)
	{
		cout << s.ver[i].sitename << "     ";
		f++;
		if (f % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "共" << s.vernum << "个" << endl;
	cout << "=======================================================================" << endl;
	cout << "目前已有路径如下：" << endl;
	for (int m = 1; m <= s.edgenum; m++)
	{
		cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
		if (m % 4 == 0)
			cout << endl;
	}
	cout << endl;
	cout << "共" << s.edgenum << "条路径" << endl;
	cout << "请输入要增加的路径的起点，终点及长度：" << endl;
	cin >> new_start >> new_end >> new_weight;      //图中需要增加，边的结构体也需要增加
	s.edgenum++;
	s.edg[s.edgenum].start = new_start;
	s.edg[s.edgenum].end = new_end;
	s.edg[s.edgenum].weight = new_weight;

	ii = LocateVex(s, new_start);
	jj = LocateVex(s, new_end);
	s.AdjMatrix[ii][jj] = new_weight;
	s.AdjMatrix[jj][ii] = new_weight;
	/*cout << "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"<<endl;
	int fff = 0;
	for(int i=1;i<=s.vernum;i++)
		for (int j = 1; j <= s.vernum; j++)
		{
			cout << s.AdjMatrix[i][j] << "  ";
			fff++;
			if (fff%s.vernum == 0)
				cout << endl;
		}
	cout << endl;
	cout << "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"<<endl;*/
	cout << "您增加了一条路径后，目前已有路径如下：" << endl;
	for (int m = 1; m <= s.edgenum; m++)
	{
		cout << s.edg[m].start << "-->" << s.edg[m].end << ": " << s.edg[m].weight << "    ";
	}
	cout << endl;
	cout << "共" << s.edgenum << "条路径" << endl;
	cout << "按任意键结束本次服务" << endl;
	getchar();
	getchar();
	system("cls");
	PrintBackground_afterlogin_menu(s);
}






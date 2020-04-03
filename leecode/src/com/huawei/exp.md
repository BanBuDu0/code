# 算法
## Tarjan
R. Tarjan, Enumeration of the elementary circuits of a directed graph, SIAM J. Comput., 2 (1973)  
Tarjan在1973年提出，最坏情况下复杂度为$o(n*e(c+1)$
## Johnson
D.B.Johnson, Finding all the elementary circuits of a directed graph, SIAM J. Comput., 4 (1975)  
Johnson在1975年提出，是对Tarjan算法的改进，改进了Tarjan算法的复杂度，最坏情况下为$o((n+e)(c+1))$，n是顶点数、e是边数，c是环数
## Hawick and James
K. A. Hawick, H. A. James. Enumerating Circuits and Loops in Graphs with Self-Arcs and Multiple-Arcs. Computational Science Technical Note CSTN-013, 2008  
Hawick and James在2008年提出，对Johnson算法的改进，消除其局限性，即能检测出指向自己的边和两个顶点之间的多条相同的边，如 $a -> a$或$a -> b, a -> b$
本实验中不需要此功能
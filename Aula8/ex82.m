%% alinea a
T = [1/3 1/4 0
    1/3 11/20 1/2
    1/3 1/5 1/2];
%% alinea b
V = [60     %A
    15      %B
    15];    %C , para 90 alunos
%% alinea c
resp = T^29 * V;
c = round(resp)
%% alinea d
V1 = [30
    30
    30];
resp = T^29 * V1;
d = round(resp)
%C�digo base para o gui�o PL07 MPEI 2019-2020
udata = load ('u.data');  %Carrega o ficheiro dos dados dos filmes
%Fica apenas com as duas primeriras colunas
u = udata(1:end, 1:2);
clear udata;

%Lista de utilizadores
users = unique(u(:,1));   %Extrai os IDs dos utilizadores
%Nu = length(users); %N�mero de utilizadores
Nu=10;
%Constr�i a lista de filmes para cada utilizador
Set = cell(Nu,1); %usa c�lulas
for n=1:Nu %Para cada utilizador
    %Obt�m os filmes de cada um
    ind = find(u(:,1) == users(n));    % E guarda num array. Usa c�lulas porque o utilizador tem um n�mero
    %diferente de filmes. Se fosse iguais podia ser um array
    Set{n} = [Set{n} u(ind,2)];
end

F = zeros(Nu, 100);
%Calcula a distancia de Jaccard entre todos os pares pela deinicao

J = zeros(Nu,Nu); %array para guardar dist�ncias
h = waitbar(0,'Calculating');
    
for n1=1:Nu
    F(n1) = minhash(Set{n1},100);
end
for n1=1:Nu
    waitbar(n1/Nu,h);
    for n2=n1+1:Nu
        J(n1,n2) = distJ(F(n1),F(n2));
    end
end
delete(h)
%Com base na dist�ncia, determina pares com
%dist�ncia inferior a um limiar pr�-definido

threshold = 0.4; %limiar da decis�o

%Array para guardar pares similaters (user1, user2, dist�ncia)
SimilarUsers = zeros(1,3);
k=1;
for n1=1:Nu
    for n2= n1+1:Nu
        if J(n1,n2)<= 0.4
            SimilarUsers(k,:) = [users(n1) users(n2) J(n1,n2)];
            k=k+1;
        end
    end
end

SimilarUsers

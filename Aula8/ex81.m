%%alinea a
T = [0.2  0.3
    0.8  0.7];
VA = [0;1];

V1 = T*VA;
V2 = T*V1;
ur = T^2 * VA;
resp = ur(2)

%%alinea b
VB = [1;0];

V3 = T*VB;
V4 = T*V3;

ur = T^2 * VB;
resp1 = ur(2)

%%alinea c
T = [0.2  0.3; 0.8  0.7];
V = [0;1];

V1 = T*V;
V2 = T*V1;

ur = T^29 * V1;
resp2 = ur(1)

%%alinea d
T = [0.2  0.3
    0.8  0.7];
V = [0.15 ;0.85];

V1 = T*V;
V2 = T*V1;

for n = 1:30
    ur = T^n * V;
    resp3 = ur(1);
end

resp3
push 0
push function0
push function1
lfp
push 5
push 7
push 2
lfp
push -3
lfp
add
lw
js
halt

function0:
cfp
lra
push 1
lfp
add
lw
print
push 2
lfp
add
lw
print
push 3
lfp
add
lw
push 4
lfp
add
lw
add
push 4
lfp
add
sw
push 0
push 3
lfp
add
sw
push 4
lfp
add
lw
srvi
push 0
push 4
lfp
add
sw
srv
pop
sra
pop
pop
pop
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
lfp
push 3
lfp
add
lw
push 3
lfp
add
lw
push 2
lfp
add
lw
push 1
lfp
add
lw
lfp
lw
push -2
lfp
lw
add
lw
js
lfp
push 3
lfp
add
lw
push 3
lfp
add
lw
push 2
lfp
add
lw
push 2
lfp
add
lw
lfp
lw
push -2
lfp
lw
add
lw
js
srv
pop
sra
pop
pop
pop
pop
sfp
lrv
lra
js

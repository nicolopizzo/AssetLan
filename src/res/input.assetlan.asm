push 0
push 0
push 0
push function0
push function1
lfp
push 3
push 2
push 1
lfp
push -5
lfp
add
lw
js
halt

function0:
cfp
lra
push 2
lfp
add
lw
push -3
lfp
lw
add
lw
add
push -3
lfp
lw
add
sw
push 0
push 2
lfp
add
sw
lfp
push 2
lfp
add
lw
push 0
push 2
lfp
add
sw
push 4
lfp
add
lw
push 0
push 4
lfp
add
sw
push 3
lfp
add
lw
push 0
push 3
lfp
add
sw
push 1
lfp
add
lw
lfp
lw
push -4
lfp
lw
add
lw
js
srv
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
push 0
push 3
lfp
add
sw
push 2
lfp
add
lw
push 0
push 2
lfp
add
sw
push 1
lfp
add
lw
push 0
push 1
lfp
add
sw
push 1
lfp
add
lw
lfp
lw
push -4
lfp
lw
add
lw
js
push -3
lfp
lw
add
lw
srvi
push 0
push -3
lfp
lw
add
sw
srv
sra
pop
pop
pop
pop
sfp
lrv
lra
js

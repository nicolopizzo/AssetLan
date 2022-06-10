push 0
push 0
push function0
push function1
lfp
push 1
lfp
push -4
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
push 0
beq label2
push 0
b label3
label2:push 1
label3:
push 0
beq label0
push 2
lfp
add
lw
push -2
lfp
lw
add
lw
add
push -2
lfp
lw
add
sw
push 0
push 2
lfp
add
sw
b label1
label0:
push 2
lfp
add
lw
push -2
lfp
lw
add
lw
add
push -2
lfp
lw
add
sw
push 0
push 2
lfp
add
sw
push 3
lfp
add
lw
push -2
lfp
lw
add
lw
add
push -2
lfp
lw
add
sw
push 0
push 3
lfp
add
sw
label1:
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

function1:
cfp
lra
lfp
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
push 0
push 1
lfp
add
sw
push 0
lfp
lw
push -3
lfp
lw
add
lw
js
push -2
lfp
lw
add
lw
srvi
push 0
push -2
lfp
lw
add
sw
srv
sra
pop
pop
sfp
lrv
lra
js

push 0
push function0
push function1
lfp
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
push 0
push 0
beq label0
push 0
b label1
label0:
push 1
label1:
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
lfp
lfp
lw
push -2
lfp
lw
add
lw
js
print
srv
sra
pop
sfp
lrv
lra
js

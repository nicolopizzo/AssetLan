push 0
push 1
push function0
push function1
push function2
lfp
push 10
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
push 1
lfp
add
lw
push 1
bleq label2
push 0
b label3
label2:
push 1
label3:
push 0
beq label0
push 1
b label1
label0:
lfp
push 1
lfp
add
lw
push 1
sub
lfp
lw
push -3
lfp
lw
add
lw
js
lfp
push 1
lfp
add
lw
push 2
sub
lfp
lw
push -3
lfp
lw
add
lw
js
add
label1:
srv
sra
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 1
lfp
add
lw
push 0
beq label16
push 0
b label17
label16:
push 1
label17:
push 0
beq label14
push -2
lfp
lw
add
lw
print
b label15
label14:
push -2
lfp
lw
add
lw
push 1
lfp
add
lw
mult
push -2
lfp
lw
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
push 1
lfp
add
lw
push 1
sub
lfp
lw
push -4
lfp
lw
add
lw
js
label15:
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 0
lfp
push 1
lfp
add
lw
lfp
lw
push -3
lfp
lw
add
lw
js
push -6
lfp
add
sw
push -6
lfp
add
lw
print
srv
pop
sra
pop
pop
sfp
lrv
lra
js

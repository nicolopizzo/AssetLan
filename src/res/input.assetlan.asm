push 0
push 0
push 0
push function0
lfp
push 2
push 5
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
push 2
lfp
add
lw
print
push -3
lfp
lw
add
lw
print
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
push 2
lfp
add
lw
print
push -3
lfp
lw
add
lw
print
srv
pop
pop
pop
sra
pop
pop
pop
sfp
lrv
lra
js

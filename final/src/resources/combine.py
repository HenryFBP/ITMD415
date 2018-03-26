files = [
	'car.sql',
	'part.sql',
	'producttype.sql',
	'customer.sql',
	'product.sql',
	'listing.sql',
	'forum.sql',
]
datafile = 'data.sql'

outname = '_out.sql'
dropname = '_drop.sql'
reset_create_insert = '_reset_create_insert.sql'

lines = []
droplines = []
datalines = []


if __name__ == '__main__':

	for filepath in files:
	
		f = open(filepath, 'r')
		
		for line in f:
		
			#if it has 'drop' in it, append it to the droplines file
			if 'DROP' in line.upper():
				droplines.append(line.replace('--',''))
			
			#append line normally
			lines.append(line)
		
		f.close()
	
	# write all CREATE lines
	with open(outname, 'w') as f:
		for line in lines:
			f.write(line)
	
	#write drop lines
	with open(dropname, 'w') as f:
		for line in droplines:
			f.write(line)
			
	with open(reset_create_insert, 'w') as f:
		# drop
		for line in droplines:
			f.write(line)
		
		# create
		for line in lines:
			f.write(line)
			
		# insert data from datafile
		with open(datafile, 'r') as df:
			for line in df:
				f.write(line)

function str = random_string(length, type)
	%ASCII Character codes
	if (type == 1)
		% Upper case letters
		% A = 65 ... Z = 90
		str = char(65 + floor(26 .* rand(length,1)))';
    else (type == 2);
		% Lower case letters
		% a = 97 ... z = 122
		str = char(97 + floor(26 .* rand(length,1)))';
	end
end
/*
 * Copyright (c) 2018 Villu Ruusmann
 *
 * This file is part of JPMML-Evaluator
 *
 * JPMML-Evaluator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-Evaluator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-Evaluator.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.evaluator;

import org.dmg.pmml.DataType;

abstract
public class Vote implements Computable, HasPrediction {

	private Object result = null;


	protected Vote(){
	}

	abstract
	protected void computeResult(DataType dataType);

	@Override
	public Object getResult(){

		if(this.result == null){
			throw new EvaluationException("Vote result has not been computed");
		}

		return this.result;
	}

	protected void setResult(Object result){
		this.result = result;
	}

	@Override
	public String toString(){
		ToStringHelper helper = toStringHelper();

		return helper.toString();
	}

	protected ToStringHelper toStringHelper(){
		ToStringHelper helper = new ToStringHelper(this)
			.add("result", getResult());

		return helper;
	}

	@Override
	public Object getPrediction(){
		return getResult();
	}

	@Override
	public Report getPredictionReport(){
		return null;
	}
}
class CliquesController < ApplicationController
  before_action :set_clique, only: %i[ show destroy ]
  before_action :set_network, only: [:create]

  # GET /cliques
  def index
    @cliques = Clique.all

    render json: @cliques
  end

  # GET /cliques/1
  def show
    render json: @clique
  end

  # POST /cliques
  def create
    p @network.id
    @clique = Clique.new(network: @network)

    if @clique.save
      render json: @clique, status: :created, location: @clique
    else
      render json: @clique.errors, status: :unprocessable_entity
    end
  end

  # DELETE /cliques/1
  def destroy
    @clique.destroy!
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_clique
      @clique = Clique.find(params[:id])
    end

    def set_network
      @network = Network.find(params[:network_id])
    end

    # Only allow a list of trusted parameters through.
    def clique_params
      #params.require(:clique).permit(:network_id)
      params.require(:network_id)
    end
end
